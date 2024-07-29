import pandas as pd

def biggest_single_number(my_numbers: pd.DataFrame) -> pd.DataFrame:
    grouped = my_numbers.groupby('num').size().reset_index(name='count')
    sorted_group = grouped.sort_values(['count', 'num'], ascending = [True, False])

    if sorted_group.iloc[0]['count'] != 1:
        return pd.DataFrame({'num' : [None]})
    return pd.DataFrame({'num' : [sorted_group.iloc[0]['num']]})

"""
import pandas as pd

def biggest_single_number(my_numbers: pd.DataFrame) -> pd.DataFrame:
    return my_numbers.drop_duplicates(keep=False).max().to_frame(name='num')
"""