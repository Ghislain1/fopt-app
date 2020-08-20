package fopt.pp2020.lin.tag3.aufgabe3;

import java.io.IOException;

public interface TCPSocketAdvance extends AutoCloseable
{
    public void sendLine(Object o) throws IOException;

    public String receiveLine() throws IOException;
}
