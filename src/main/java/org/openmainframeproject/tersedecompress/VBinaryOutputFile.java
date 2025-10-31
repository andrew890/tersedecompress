package org.openmainframeproject.tersedecompress;

import java.io.*;
import java.nio.*;

public class VBinaryOutputFile implements AutoCloseable, OutputFile
{
	private static final int RDWLEN=4;
	
	public VBinaryOutputFile(OutputStream out, int lrecl)
	{
		this.out = new BufferedOutputStream(out);
		
		byte[] buffer = new byte[lrecl+ RDWLEN];
		record = ByteBuffer.wrap(buffer); // default order is bigendian
		record.position(RDWLEN);
	}
	
	private final ByteBuffer record;
	private final OutputStream out;
	private int recbytes = 0;
		
    /* Write a new line to the output file*/
    public void endRecord() throws IOException 
    {
		// write a RDW
		int recordlength = recbytes + RDWLEN;
		int rdw = recordlength << 16;
		record.putInt(0, rdw);
    	out.write(record.array(), 0, recordlength);
    	record.position(RDWLEN); // data after RDW
    	recbytes = 0;
    }

    /*
     * Write some stuff to the output record
     */
    @Override
    public void PutChar(int X) throws IOException 
    {
    	if (X == 0) return;
        if (X == Constants.RECORDMARK) 
        {
       		endRecord();
        }
        else
        {
        	record.put((byte)(X-1));
        	recbytes++;
        }
    }

	@Override
	public void close() throws IOException 
	{
		if (recbytes > 0)
		{
			endRecord();
		}
		this.out.close();
	}
}
