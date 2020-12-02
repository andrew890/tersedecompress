package com.blackhillsoftware.terse;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class DecompressedOutputWriter implements AutoCloseable
{
	DataOutputStream stream;
	
	ByteArrayOutputStream record;
	
	boolean HostFlag; 
	boolean TextFlag;
	boolean VariableFlag;
	
    int         RecordLength; /* host perspective record length           */
	
    byte[] lineseparator = System.lineSeparator().getBytes();
    
	public DecompressedOutputWriter(TerseHeader header, OutputStream outstream)
	{
		this.stream = new DataOutputStream(outstream);
		this.RecordLength = header.RecordLength;
		this.HostFlag = header.HostFlag; 
		this.TextFlag = header.TextFlag;
		this.VariableFlag = header.RecfmV;
		
		this.record = new ByteArrayOutputStream(RecordLength);
	}
	
	
    /* Write the record to the output file*/
    public void writeRecord() throws IOException 
    {
    	byte[] recordBytes = record.toByteArray();
    	if (TextFlag)
    	{
    		stream.write(recordBytes, 0, recordBytes.length);
    		stream.write(lineseparator);
    	}
    	else
    	{
    		if (VariableFlag)
    		{
    			// write the RDW then the data
    			stream.writeShort(recordBytes.length);
    			stream.writeShort(0);
        		stream.write(recordBytes, 0, recordBytes.length);    			
    		}
    		else
    		{
    			// just write the data
        		stream.write(recordBytes, 0, recordBytes.length);    			
    		}
    	}
        record.reset();
    }

    /*
     * Write some stuff to the output file
     */

    public void PutChar(int X) throws IOException 
    {
    	if (HostFlag)
    	{
			if (VariableFlag)
			{
                if (X == Constants.RECORDMARK) 
                {
                    writeRecord();
                } 
                else 
                {
                	record.write(TextFlag ? Constants.EbcToAsc[X-1] : X-1);
                }
			}
			else
			{
	            if (X < Constants.RECORDMARK) /* discard record marks */
	            { 
                	record.write(TextFlag ? Constants.EbcToAsc[X-1] : X-1);
	            }
	            if (record.size() >= RecordLength)
	            {
                    writeRecord();	
	            }				
			}
    		
    	} 
    	else {
	        if (X < Constants.RECORDMARK) { /* discard record marks */
	        	stream.write(X-1);
	        }
	    }
    }

	@Override
	public void close() throws IOException 
	{
		if (record.size() > 0)
		{
			writeRecord();
		}
		this.stream.close();
	}
}
