package fopt.pp2020.lin.tag3.aufgabe3.lehrbuch;

import java.io.IOException;

public interface TCPSocket extends AutoCloseable
{
    public void sendLine(String mgs) throws IOException;

    public String receiveLine() throws IOException;
}
