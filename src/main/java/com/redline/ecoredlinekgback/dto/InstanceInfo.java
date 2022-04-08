package com.redline.ecoredlinekgback.dto;

import com.redline.ecoredlinekgback.pojo.Instance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstanceInfo {
    List<Instance> instances;
    int totalNum;
}
