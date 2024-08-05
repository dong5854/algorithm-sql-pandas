import pandas as pd

def project_employees_i(project: pd.DataFrame, employee: pd.DataFrame) -> pd.DataFrame:
    merged = project.merge(employee, on='employee_id', how='left')
    grpby = merged[['project_id', 'experience_years']].groupby('project_id')\
    .apply(lambda x : round(x.mean(),2))
    grpby.columns = ['project_id', 'average_years']
    return grpby