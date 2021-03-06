/*
 * Copyright (C) 2015 - 2016 Mitch Talmadge (https://mitchtalmadge.com/)
 * Emoji Tools helps users and developers of Android, iOS, and OS X extract, modify, and repackage Emoji fonts.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mitchtalmadge.emojitools.gui.dialogs.dialogcontrollers;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import com.mitchtalmadge.emojitools.EmojiTools;
import com.mitchtalmadge.emojitools.gui.dialogs.OperationProgressDialog;

public class OperationProgressDialogController {

    @FXML
    protected Button cancelButton;

    @FXML
    protected ProgressBar progressBar;

    @FXML
    protected TextArea outputTextArea;

    @FXML
    protected Label headerLabel;

    private OperationProgressDialog parent;

    @FXML
    protected void onCancelButtonFired(ActionEvent event) {
        parent.cancel();
    }

    public void setHeaderText(String headerText) {
        this.headerLabel.setText(headerText);
    }

    public void bindProgressToProperty(ReadOnlyDoubleProperty property) {
        this.progressBar.progressProperty().bind(property);
    }

    public void bindMessagesToProperty(ReadOnlyStringProperty property) {
        this.outputTextArea.textProperty().bind(property);
        property.addListener((observable, oldValue, newValue) -> {
            outputTextArea.setScrollTop(Double.MAX_VALUE);
            outputTextArea.positionCaret(outputTextArea.getText().length()-1);
        });
    }

    public void setParent(OperationProgressDialog parent) {
        this.parent = parent;
    }
}
