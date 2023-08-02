class FancyTuple:
    def __init__(self, *args) -> None:
        n = len(args)
        
        if 1 <= n and args[0]:
            self.first = args[0]
        if 2 <= n and args[1]:
            self.second = args[1]
        if 3 <= n and args[2]:
            self.third = args[2]
        if 4 <= n and args[3]:
            self.fourth = args[3]
        if 5 <= n and args[4]:
            self.fifth = args[4]
        
        self.size = n
        
        return

    def __len__(self) -> int:
        return self.size
    
def main() -> None:
    # Add Unit Testing
    return

if __name__ == "__main__":
    main()