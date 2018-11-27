#quicksort

def quicksort(arr, lower, upper):
    """Sorts the elements in arr between upper and lower boundary with the quicksort algorithm"""
    if lower < upper:
        p = partition(arr, lower, upper)
        quicksort(arr, lower, p-1)
        quicksort(arr, p+1, upper)


def partition(arr, lower, upper):
    pivot = arr[upper]
    i = lower
    for j in range(lower, upper-1):
        if arr[j] < pivot:
            if i != j:
                # swap the elements in arr[i] and arr[j]
                arr[i] += arr[j]
                arr[j] = arr[i] - arr[j]
                arr[i] -= arr[j]
            i += 1
    # swap the elements in arr[i] and arr[upper]
    arr[i] += arr[upper]
    arr[upper] = arr[i] - arr[upper]
    arr[i] -= arr[upper]
    return i
