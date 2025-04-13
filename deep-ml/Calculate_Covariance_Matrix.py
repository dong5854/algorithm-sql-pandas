def calculate_covariance_matrix(vectors: list[list[float]]) -> list[list[float]]:
    num_features = len(vectors)
    num_observations = len(vectors[0])

    means = [sum(feature) / num_observations for feature in vectors]

    cov_matrix = []
    for i in range(num_features):
        row = []
        for j in range(num_features):
            cov = sum(
                (vectors[i][k] - means[i]) * (vectors[j][k] - means[j])
                for k in range(num_observations)
            ) / (num_observations - 1)
            row.append(cov)
        cov_matrix.append(row)

    return cov_matrix
