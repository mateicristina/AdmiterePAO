package com.participant.dosar;

import java.util.List;

public class Dosar {
    private Integer nrDocumente;
    private List<String> documente;

    public Dosar(Integer nrDocumente, List<String> documente) {
        this.nrDocumente = nrDocumente;
        this.documente = documente;
    }

    public List<String> getDocumente() { return documente; }

    public void setDocumente(List<String> documente) { this.documente = documente; }

    public Integer getNrDocumente() { return nrDocumente; }

    public void setNrDocumente(Integer nrDocumente) { this.nrDocumente = nrDocumente; }
}
