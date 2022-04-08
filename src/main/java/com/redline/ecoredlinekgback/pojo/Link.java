package com.redline.ecoredlinekgback.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    String id; // line id
    String from; // source node id
    String to; // target node id
    String name; // relation name
    String description; // relation detail
}
