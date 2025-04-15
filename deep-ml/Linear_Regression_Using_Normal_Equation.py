import numpy as np
def linear_regression_normal_equation(X: list[list[float]], y: list[float]) -> list[float]:
    X = np.array(X)
    Y = np.array(y)
    X_transpose = X.T

    theta = np.linalg.pinv(X_transpose @ X) @ X_transpose @ Y
    theta = np.round(theta, 4)

    return theta.flatten().tolist()