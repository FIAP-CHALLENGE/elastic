package br.com.fiap.pagseguro.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBulkInsertItemVO {

    private IndexVO index;

    public IndexVO getIndex() {
        return index;
    }

    public void setIndex(final IndexVO index) {
        this.index = index;
    }

    @Override
    public String toString () {
        final StringBuilder builder = new StringBuilder()//
                .append("ResponseBulkInsertItemVO [")//
                .append("index=")//
                .append(index)//
                .append("]");
        return builder.toString();
    }
}
