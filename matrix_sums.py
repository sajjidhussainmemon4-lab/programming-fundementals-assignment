def calculate_matrix_sums():
    try:
        n = int(input("Enter the size of the square matrix (N x N): "))
    except ValueError:
        print("Invalid input. Please enter an integer.")
        return

    matrix = []
    print(f"Enter the elements of the {n}x{n} matrix row by row (space separated):")
    
    for i in range(n):
        while True:
            try:
                row_input = input(f"Row {i+1}: ").strip().split()
                if len(row_input) != n:
                    print(f"Please enter exactly {n} numbers.")
                    continue
                row = [float(x) for x in row_input]
                matrix.append(row)
                break
            except ValueError:
                print("Invalid input. Please enter numerical values.")

    print("\n--- Matrix Sums ---")
    
    # 1. Sum of rows
    for i in range(n):
        row_sum = sum(matrix[i])
        print(f"Sum of Row {i+1} : {row_sum}")

    # 2. Sum of columns
    for j in range(n):
        col_sum = sum(matrix[i][j] for i in range(n))
        print(f"Sum of Column {j+1} : {col_sum}")

    # 3. Sum of forward diagonal (Principal Diagonal: top-left to bottom-right)
    forward_diagonal_sum = sum(matrix[i][i] for i in range(n))
    print(f"Sum of Forward Diagonal : {forward_diagonal_sum}")

    # 4. Sum of reverse diagonal (Secondary Diagonal: top-right to bottom-left)
    reverse_diagonal_sum = sum(matrix[i][n - 1 - i] for i in range(n))
    print(f"Sum of Reverse Diagonal : {reverse_diagonal_sum}")

if __name__ == "__main__":
    calculate_matrix_sums()

