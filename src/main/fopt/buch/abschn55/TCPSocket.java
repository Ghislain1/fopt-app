package fopt.buch.abschn55;

import java.io.IOException;

public interface TCPSocket extends AutoCloseable
{
    public void sendLine(String mgs) throws IOException;

    public String receiveLine() throws IOException;
}
