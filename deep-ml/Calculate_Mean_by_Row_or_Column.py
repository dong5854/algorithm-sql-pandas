def calculate_matrix_mean(matrix: list[list[float]], mode: str) -> list[float]:
    means: list[float] = []
    if mode == "row":
        means = [sum(row, 0.0) / len(row) for row in matrix]
    elif mode == "column":
        means = [sum(col, 0.0) / len(col) for col in zip(*matrix)]
	return means