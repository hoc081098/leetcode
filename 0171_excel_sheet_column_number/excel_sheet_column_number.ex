defmodule Solution do
  @spec title_to_number(column_title :: String.t) :: integer
  def title_to_number(column_title) do
    import Enum
    column_title
        |> String.to_charlist
        |> map(&( &1 - ?A + 1 ))
        |> reduce 0, &( &2 * 26 + &1 )
  end
end
