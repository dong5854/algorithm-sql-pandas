import numpy as np

def reshape_matrix(a: list[list[int|float]], new_shape: tuple[int, int]) -> list[list[int|float]]:
	#Write your code here and return a python list after reshaping by using numpy's tolist() method
    np_array = np.array(a)
    if np_array.size != new_shape[0] * new_shape[1]:
        return []
    return np_array.reshape(new_shape).tolist()