/*
 *  Copyright 2020 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.slidingtiles.model.metric;

import edu.cnm.deepdive.slidingtiles.model.Puzzle;
import edu.cnm.deepdive.slidingtiles.model.Tile;

/**
 * TODO Write Javadoc comment.
 *
 * @author Nicholas Bennett, Chris Hughes
 */
public class InPlace extends BaseMeasure {

  /**
   * TODO Write Javadoc comment.
   *
   * @param puzzle
   * @return
   */
  @Override
  public int getMeasure(Puzzle puzzle) {
    Tile[][] tiles = puzzle.getTiles();
    int size = puzzle.getSize();
    int measure = 0;
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        Tile tile = tiles[row][col];
        if (tile != null) {
          int tileNumber = tiles[row][col].getNumber();
          int homeRow = tileNumber / size;
          int homeCol = tileNumber % size;
          if (row == homeRow && col == homeCol) {
            measure++;
          }
        }
      }
    }
    return measure;
  }

}
