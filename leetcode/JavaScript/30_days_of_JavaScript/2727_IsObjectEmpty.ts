type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | JSONValue[]

function isEmpty(obj: Record<string, any> | any[]): boolean {
  if (JSON.stringify(obj).length <= 2) {
    return true;
  } else {
    return false;
  }
}