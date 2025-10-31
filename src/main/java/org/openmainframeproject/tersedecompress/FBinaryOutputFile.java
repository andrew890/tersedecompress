package org.openmainframeproject.tersedecompress;

import java.io.*;

public class FBinaryOutputFile implements AutoCloseable, OutputFile
{
	public FBinaryOutputFile(OutputStream out, int lrecl)
	{
		this.out = new DataOutputStream(new BufferedOutputStream(out));
	}
	private final DataOutputStream out;
	
    /*
     * Write some stuff to the output record
     */
	@Override
    public void PutChar(int X) throws IOException 
    {
    	if (X == 0) return;
       	out.write((byte)(X-1));        
    }

	@Override
	public void close() throws IOException 
	{
		this.out.close();
	}	
}
