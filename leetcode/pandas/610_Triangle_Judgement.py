import pandas as pd

def triangle_judgement(triangle: pd.DataFrame) -> pd.DataFrame:
    data = {
            "x" : [],
            "y" : [],
            "z" : [],
            "triangle" : []
        }
    for x,y,z in zip(triangle["x"], triangle["y"], triangle["z"]):
        sorted_list = sorted([x,y,z])
        data["x"].append(x)
        data["y"].append(y)
        data["z"].append(z)
        data["triangle"].append("Yes" if sorted_list[2] < sorted_list[0] + sorted_list[1] else "No")

    return pd.DataFrame(data)