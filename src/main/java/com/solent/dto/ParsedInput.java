package com.solent.dto;

import com.solent.domain.Grid;
import com.solent.domain.Mower;

import java.util.List;

public record ParsedInput(Grid grid, List<Mower> mowers, List<List<Character>> commands) {}

