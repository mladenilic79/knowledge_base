class CreateParents < ActiveRecord::Migration[6.0]
  def change
    create_table :parents do |t|
      t.string :parent_name
      t.integer :parent_number

      t.timestamps
    end
  end
end
