import numpy as np

def linear_regression_gradient_descent(X: np.ndarray, y: np.ndarray, alpha: float, iterations: int) -> np.ndarray:
    # X: 입력 특성 행렬 (샘플 수 m × 피처 수 n)
    # y: 정답 벡터 (m,) 형태로 들어옴
    # alpha: 학습률 (learning rate)
    # iterations: 반복 횟수
    # 반환값: 학습된 파라미터 벡터 theta (n,)

    m, n = X.shape  # m: 샘플 수, n: 피처 수
    theta = np.zeros((n, 1))  # 초기 파라미터 벡터 θ를 모두 0으로 초기화 (n×1 벡터)
    y = y[:, None]  # y를 열 벡터 (m×1)로 변환 → X@θ와 차원 맞추기 위해

    for _ in range(iterations):
        predictions = X @ theta  # 예측값 계산: Xθ (m×1 벡터)
        errors = predictions - y  # 예측 오차 벡터: (Xθ - y)
        gradient = (1 / m) * X.T @ errors  # 비용 함수의 그래디언트(기울기) 계산: ∇θ J(θ)
        theta -= alpha * gradient  # 파라미터 업데이트: θ ← θ - α ∇θ J(θ)

    return np.round(theta.flatten(), 4)  # 최종 θ를 1차원 벡터로 변환 + 소수점 4자리 반올림 후 반환
