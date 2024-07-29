import pandas as pd

def sales_person(sales_person: pd.DataFrame, company: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    sales_people = set(sales_person["name"].tolist())
    os = pd.merge(left=orders, right=sales_person, how="left", on="sales_id")
    company.rename(columns={"name" : "company_name"}, inplace=True)
    osc = pd.merge(left=os, right=company, how="left", on="com_id")
    related_with_red = set(osc[osc["company_name"] == "RED"]["name"].tolist())
    data = {"NAME" : list(sales_people - related_with_red)}

    return pd.DataFrame(data)