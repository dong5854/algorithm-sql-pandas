import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    grouped_by = courses.groupby(["class"]).student.count().reset_index()
    return grouped_by.loc[grouped_by["student"] >= 5, ["class"]]