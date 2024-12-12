package com.solent.dto;

import com.solent.domain.Grid;
import com.solent.domain.Mower;

import java.util.List;

public record ParsedInput(Grid grid, Mower mower, List<Character> commands) {}

