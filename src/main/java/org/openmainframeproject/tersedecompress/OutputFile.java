package org.openmainframeproject.tersedecompress;

import java.io.IOException;

public interface OutputFile 
{
    public void PutChar(int X) throws IOException; 
    public void close() throws IOException; 
}