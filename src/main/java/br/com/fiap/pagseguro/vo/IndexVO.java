package br.com.fiap.pagseguro.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tqi_asilva
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 1/30/17 10:15 AM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexVO {

    @JsonProperty("_index")
    private String index;

    @JsonProperty("_id")
    private Long id;

    private String status;

    public String getIndex() {
        return index;
    }

    public void setIndex(final String index) {
        this.index = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString () {
        final StringBuilder builder = new StringBuilder()//
                .append("IndexVO [")//
                .append("index=\"")//
                .append(index).append("\"")//
                .append(",id=")//
                .append(id)//
                .append(",status=\"")//
                .append(status).append("\"")//
                .append("]");
        return builder.toString();
    }
}
