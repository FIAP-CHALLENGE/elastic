package br.com.fiap.pagseguro.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author tqi_asilva
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 1/30/17 11:06 AM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBulkInsertVO {

    private Boolean errors;

    private List<ResponseBulkInsertItemVO> items;

    public Boolean getErrors() {
        return errors;
    }

    public void setErrors(final Boolean errors) {
        this.errors = errors;
    }

    public List<ResponseBulkInsertItemVO> getItems() {
        return items;
    }

    public void setItems(final List<ResponseBulkInsertItemVO> items) {
        this.items = items;
    }

    @Override
    public String toString () {
        final StringBuilder builder = new StringBuilder()//
                .append("ResponseBulkInsertVO [")//
                .append("errors=")//
                .append(errors)//
                .append(",items=")//
                .append(items)//
                .append("]");
        return builder.toString();
    }
}
