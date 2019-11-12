class AddThemeReferenceToBook < ActiveRecord::Migration[6.0]
  def change
    add_reference :books, :theme, null: false, foreign_key: true
  end
end
