import numpy as np

def scalar_multiply(matrix: list[list[int|float]], scalar: int|float) -> list[list[int|float]]:
    matrix_np = np.array(matrix)
    matrix_np = matrix_np * scalar
    return matrix_np.tolist()