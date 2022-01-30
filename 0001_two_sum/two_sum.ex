defmodule Solution do
  @spec two_sum(nums :: [integer], target :: integer) :: [integer]
  def two_sum(nums, target) do
    map = nums
        |> Enum.with_index
        |> Map.new

    nums
        |> Enum.with_index
        |> Enum.find_value(fn {v, i} -> 
            j = Map.get map, target - v
            if j && j != i, do: [i, j]
          end)
  end
end
