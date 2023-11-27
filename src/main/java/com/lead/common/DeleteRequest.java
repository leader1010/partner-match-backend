package com.lead.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DeleteRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -5860707094194210842L;

    private long id;


}
