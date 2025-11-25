def generate_jagged_array(size, fill_char, corner_char):
    jagged_array = []

   
    start = size // 4
    end = size - size // 4 - 1

    
    inner_start = size // 3
    inner_end = size - size // 3 - 1

    inner_char = '*'  

    for i in range(size):
        row = []
        for j in range(size):

            
            if (i == start and j == start) or (i == start and j == end) or \
               (i == end and j == start) or (i == end and j == end):
                row.append(corner_char)

            
            elif (i == start or i == end) and (start <= j <= end):
                row.append(fill_char)
            elif (j == start or j == end) and (start <= i <= end):
                row.append(fill_char)

            
            elif (inner_start <= i <= inner_end) and (inner_start <= j <= inner_end):
                row.append(inner_char)

            
            else:
                row.append('*')

        jagged_array.append(row)

    return jagged_array


def print_jagged(jagged_array):
    print("\nЗубчастий масив:")
    for i, row in enumerate(jagged_array):
        print(f"Рядок {i} ({len(row)} елементів):", " ".join(row))


def print_full(jagged_array):
    print("\nВигляд як повна матриця:")
    for row in jagged_array:
        print(" ".join(row))


def save_to_file(jagged_array, filename="output.txt"):
    with open(filename, "w", encoding="utf-8") as f:
        f.write("Варіант 16 - Зубчастий масив:\n")
        for i, row in enumerate(jagged_array):
            f.write(f"Рядок {i}: {' '.join(row)}\n")
    print(f"\nРезультат збережено у файл {filename}")


def main():
    try:
        size = int(input("Введіть розмір матриці (непарне число >= 5): "))
        fill_char = input("Введіть символ для зовнішньої рамки: ")
        corner_char = input("Введіть символ для кутів рамки: ")

        if size < 5 or size % 2 == 0:
            print("Помилка: розмір має бути непарним числом, не менше 5.")
            return

        jagged_array = generate_jagged_array(size, fill_char, corner_char)

        print_jagged(jagged_array)
        print_full(jagged_array)
        save_to_file(jagged_array)

    except ValueError:
        print("Помилка: введено некоректне значення. Введіть ціле число.")


if __name__ == "__main__":
    main()
