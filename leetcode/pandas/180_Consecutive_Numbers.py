import pandas as pd

def consecutive_numbers(logs: pd.DataFrame) -> pd.DataFrame:
    logs['prev_num'] = logs['num'].shift(1)
    logs['next_num'] = logs['num'].shift(-1)

    result = logs[(logs['num'] == logs['prev_num']) & (logs['num'] == logs['next_num'])]

    consecutive_nums = result["num"].unique()
    
    return pd.DataFrame({'ConsecutiveNums': consecutive_nums})