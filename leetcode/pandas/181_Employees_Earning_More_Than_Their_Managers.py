import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    merged : pd.DataFrame = employee.merge(employee, how='inner', left_on="managerId", right_on="id")
    merged : pd.DataFrame = merged[merged["salary_x"] > merged["salary_y"]][["name_x"]]
    return merged.rename(columns={"name_x": "Employee"})
