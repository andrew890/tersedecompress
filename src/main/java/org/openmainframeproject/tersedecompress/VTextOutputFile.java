package org.openmainframeproject.tersedecompress;

import java.io.*;

public class VTextOutputFile implements AutoCloseable, OutputFile
{
	public VTextOutputFile(OutputStream out, int lrecl)
	{
		this.out = new DataOutputStream(new BufferedOutputStream(out));
	}
	private final DataOutputStream out;
	private static final byte[] lineseparator = System.lineSeparator().getBytes();
	
    /* Write a new line to the output file*/
	private void endRecord() throws IOException 
    {    	
   		out.write(lineseparator);
    }

    /*
     * Write some stuff to the output record
     */
	@Override
    public void PutChar(int X) throws IOException {
        if (X == 0 || X == Constants.RECORDMARK) 
        {
            endRecord();
        } else {
           	out.write((byte)(Constants.EbcToAsc[X-1]));
        }
    }

	@Override
	public void close() throws IOException {
			endRecord();
		out.close();
	}
}
