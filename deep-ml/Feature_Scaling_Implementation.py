import numpy as np

def feature_scaling(data: np.ndarray) -> (np.ndarray, np.ndarray):
    # === 표준화 (Standardization): 평균 0, 표준편차 1 ===
    mean = np.mean(data, axis=0)           # 각 열(특징)의 평균
    std = np.std(data, axis=0)             # 각 열의 표준편차
    std[std == 0] = 1                      # 표준편차가 0이면 나누기 오류 방지용으로 1로 설정
    standardized_data = (data - mean) / std

    # === 정규화 (Min-Max Normalization): 0 ~ 1 범위로 스케일링 ===
    min_val = np.min(data, axis=0)         # 각 열의 최소값
    max_val = np.max(data, axis=0)         # 각 열의 최대값
    range_val = max_val - min_val
    range_val[range_val == 0] = 1          # max와 min이 같으면 나누기 에러 방지
    normalized_data = (data - min_val) / range_val

    # 소수점 4자리까지 반올림하고 리스트로 변환
    return np.round(standardized_data, 4).tolist(), np.round(normalized_data, 4).tolist()
