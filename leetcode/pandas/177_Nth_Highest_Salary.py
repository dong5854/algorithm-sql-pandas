import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:

    drop_duplicates = employee['salary'].drop_duplicates()
    employee_sorted = drop_duplicates.sort_values()

    if N > len(employee):
        return pd.DataFrame({f"getNthHighestSalary({N})": [None]})

    nth_highest = employee_sorted.iloc[N - 1]

    return pd.DataFrame({f"getNthHighestSalary({N})": [nth_highest]})
