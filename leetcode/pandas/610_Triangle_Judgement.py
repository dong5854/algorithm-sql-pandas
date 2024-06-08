import pandas as pd


def triangle_judgement(triangle: pd.DataFrame) -> pd.DataFrame:
    triangle["triangle"] = (triangle["x"] + triangle["y"] > triangle["z"]) & (
        triangle["z"] + triangle["y"] > triangle["x"]) & (triangle["x"] + triangle["z"] > triangle["y"])
    triangle["triangle"] = triangle["triangle"].apply(
        lambda x: "Yes" if x else "No")
    return triangle
