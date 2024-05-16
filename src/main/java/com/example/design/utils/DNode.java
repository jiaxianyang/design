package com.example.design.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jiaxianyang
 * @date 2024/5/13 14:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DNode<T> {

    private T value;

    DNode<T> left, right, parent;
}
