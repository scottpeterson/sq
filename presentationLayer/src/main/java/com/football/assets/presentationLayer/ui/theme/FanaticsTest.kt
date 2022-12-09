package com.football.assets.presentationLayer.ui.theme

/*
# Overview:
# Write a program, in any language, that will display an ASCII chart given the following data
# data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}.
# You should be able to print the surrounding components of the chart and then place an * where
# each data point is specified in the data set. You do not need to print the X and Y legends
# but that would be helpful. You are given the max x and max y but if you can calculate that
# it would be helpful.
#
#  Online auction graph display
#  x axis is time
#  y axis is price
#  Title item

#  Given a two-dimension array graph the price over time
#
#     +-----+-----+-----+-----+-----+-----+
#     +                             *     +
#     +                                   +
#     +                       *           +
#   $ +                                   +
#     +                                   +
#     +           *                       +
#     +     *                             +
#     +                 *                 +
#     +-----+-----+-----+-----+-----+-----+
#                time
#
#   max x = 5
#   max y = 8
#   data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}
*/

fun main() {
    val max_x = 5
    val max_y = 8
    val data = listOf((1 to 2), (2 to 3), (3 to 1), (4 to 6), (5 to 8))
    val x_axis_segment = "-----+"

    // x axis
    // + for 0
    // ---+ for each up to max x, but maybe pad this by adding 1

    // y axis
    // don't need to draw starting +, x axis will have done that
    // + for each up to max y, but maybe pad this by adding 1

    // drawing
    // we'll want to draw either row-by-row, or column-by-column
    // we need to know where to place * before we start drawing at all

    // start from the bottom

    // draw x axis
    val x_axis_printed = "+" + x_axis_segment.repeat(max_x)
    val y_to_print = x_axis_printed.length

    println(x_axis_printed)
    (1..max_y).forEach { y_indexes ->
        (1..max_x).forEach {x_indexes ->
            data.forEach { innerLoop ->
                if (x_indexes == innerLoop.first && y_indexes == innerLoop.second) {
                    print("     *")
                } else {
                    print("      ")
                }
            }
        }
    }
    println(x_axis_printed)
}
