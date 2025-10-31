package org.openmainframeproject.tersedecompress;

import java.io.*;

abstract class TerseDecompresser implements AutoCloseable
{
	protected final TerseBlockReader input;
	protected final OutputFile stream;
	    
    public abstract void decode() throws IOException;
    
    public static TerseDecompresser create(InputStream inputStream, OutputStream outputStream, boolean text) throws IOException
    {
        DataInputStream input = new DataInputStream(new BufferedInputStream(inputStream));
        TerseHeader header_rv = TerseHeader.CheckHeader(input);
        
        OutputFile outputFile = 
        		header_rv.HostFlag && header_rv.RecfmV && text ? new VTextOutputFile(outputStream, header_rv.RecordLength)
        		: header_rv.HostFlag && text ? new FTextOutputFile(outputStream, header_rv.RecordLength)
                : header_rv.RecfmV ? new VBinaryOutputFile(outputStream, header_rv.RecordLength)
                : new FBinaryOutputFile(outputStream, header_rv.RecordLength);
        
        
        if (!header_rv.SpackFlag) {
        	return new NonSpackDecompresser(input, outputFile);
        } else {
        	return new SpackDecompresser(input, outputFile);
        }
    }
    
	public TerseDecompresser(InputStream instream, OutputFile outputStream)
	{		
		this.input = new TerseBlockReader(instream);
		this.stream = outputStream;		
	}

	@Override
	public void close() throws Exception {
		this.stream.close();
		this.input.close();
	}
}
