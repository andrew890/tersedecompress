package org.openmainframeproject.tersedecompress;

import java.io.*;

public class FTextOutputFile implements AutoCloseable, OutputFile
{
	public FTextOutputFile(OutputStream out, int lrecl)
	{
		this.out = new DataOutputStream(new BufferedOutputStream(out));
		this.lrecl = lrecl;
	}
	private final DataOutputStream out;
    private final int lrecl; /* host perspective record length           */

    private static final byte[] lineseparator = System.lineSeparator().getBytes();
    private int recordbytes = 0;	
	
    /* Write a new line to the output file*/
    private void endRecord() throws IOException 
    {    	
   		out.write(lineseparator);
   		recordbytes = 0;
    }

    /*
     * Write some stuff to the output record
     */
    @Override
    public void PutChar(int X) throws IOException 
    {
    	if (X == 0) return;
    	out.write((byte)(Constants.EbcToAsc[X-1]));
    	recordbytes++;
        if (recordbytes == lrecl) {
            endRecord();
        }    
    }

	@Override
	public void close() throws IOException 
	{
		if (recordbytes > 0)
		{
			endRecord();
		}
		out.close();
	}
}
