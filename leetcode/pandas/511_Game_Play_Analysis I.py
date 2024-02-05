import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    return activity.groupby('player_id', as_index=False).agg(first_login=('event_date', 'min'))