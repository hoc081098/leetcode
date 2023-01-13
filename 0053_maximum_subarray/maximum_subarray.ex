defmodule Solution do
  @spec max_sub_array(nums :: [integer]) :: integer
  def max_sub_array(nums) do
    f = nums |> Enum.at 0
    nums
        |> Enum.drop(1)
        |> Enum.reduce({f, f}, fn e, {acc, curSum} ->
                curSum = max curSum + e, e
                { max(acc, curSum), curSum }
            end)
        |> elem 0
  end
end
