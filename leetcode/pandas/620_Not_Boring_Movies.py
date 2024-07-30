import pandas as pd

def not_boring_movies(cinema: pd.DataFrame) -> pd.DataFrame:
    df = cinema[(cinema['id']%2==1) & ~(cinema['description'].str.contains('boring'))]
    return df.sort_values(by='rating', ascending=False)