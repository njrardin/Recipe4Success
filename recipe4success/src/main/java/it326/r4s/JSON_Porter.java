package it326.r4s;

import java.util.List;

public class JSON_Porter<T extends Portable> implements Porter<T> {
    
    @Override
    public T importFrom(String filename) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> importAllFrom(String filename) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void exportFrom(String filename, T portable) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void exportAllFrom(String filename, List<T> portables) throws Exception {
        // TODO Auto-generated method stub
    }    
}
