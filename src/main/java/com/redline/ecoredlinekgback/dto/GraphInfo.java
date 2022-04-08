package com.redline.ecoredlinekgback.dto;

import com.redline.ecoredlinekgback.pojo.Link;
import com.redline.ecoredlinekgback.pojo.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphInfo {
    List<Node> nodes;
    List<Link> links;
}
