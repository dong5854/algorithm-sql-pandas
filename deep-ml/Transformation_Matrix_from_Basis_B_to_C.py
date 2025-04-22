import numpy as np

def transform_basis(B: list[list[int]], C: list[list[int]]) -> list[list[float]]:
    target_basis = np.array(C)
    original_basis = np.array(B)
    
    target_basis_inv = np.linalg.inv(target_basis)
    transformation_matrix = target_basis_inv @ original_basis
    
    return transformation_matrix.tolist()