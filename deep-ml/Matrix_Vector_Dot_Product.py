def matrix_dot_vector(a: list[list[int|float]], b: list[int|float]) -> list[int|float]:
	# Return a list where each element is the dot product of a row of 'a' with 'b'.
	# If the number of columns in 'a' does not match the length of 'b', return -1.
    if any(len(row) != len(b) for row in a):
        return -1
    return [sum(x * y for x, y in zip(row, b)) for row in a]